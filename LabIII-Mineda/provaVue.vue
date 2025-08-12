<template>
  <div>
    <p>Texto: <input type="text" v-model="texto" /></p>
    <p>Data/hora: <input type="datetime-local" v-model="dataHora" /></p>
    <p>Id Usuário: <input type="number" v-model="idUsuario" /></p>
    <p>
      Usuário:
      <select name="usuario" id="usuario" v-model="idUsuario">
        <option v-for="(usuario, index) in usuarios" :key="index" :value="usuario.id">
          {{ usuario.nome }}
        </option>
      </select>
    </p>
    <button @click="incluir">Incluir</button>
    <p>Texto: <input type="text" v-model="textoPesquisa" /></p>
    <p>
      Usuário:
      <select name="usuarioPesquisa" id="usuarioPesquisa" v-model="nomeUsuario">
        <option v-for="(usuario, index) in usuarios" :key="index" :value="usuario.nome">
          {{ usuario.nome }}
        </option>
      </select>
    </p>
    <button @click="pesquisar">Pesquisar</button>
    <p v-if="erro">{{ erro }}</p>
    <table v-if="anotacoes.length > 0">
      <thead>
        <tr>
          <td>Id</td>
          <td>Texto</td>
          <td>Antiguidade</td>
          <td>Usuário</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(anotacao, index) in anotacoes" :key="index">
          <td>{{ anotacao.id }}</td>
          <td>{{ anotacao.texto }}</td>
          <td>{{ monthDifference(new Date(anotacao.dataHora)) }} meses</td>
          <td>{{ anotacao.usuario.nome }}</td>
        </tr>
      </tbody>
    </table>
    <p v-else>Nenhum registro foi encontrado para os critérios fornecidos</p>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import axios from 'axios'
import { onMounted } from 'vue'

const texto = ref<string>('')
const dataHora = ref<Date>()
const idUsuario = ref<number>()
const erro = ref<string>('')

const nomeUsuario = ref<string>()
const textoPesquisa = ref<string>()

const anotacoes = ref([
  { id: 1, texto: 'Anotação', dataHora: '2023-08-01T19:10:00', usuario: { id: 1, nome: 'admin' } },
])

const usuarios = ref([
  { id: 1, nome: 'admin', senha: '123' },
  { id: 2, nome: 'teste', senha: 'abc' },
])

async function buscarUsuarios() {
  try {
    usuarios.value = (await axios.get('usuario')).data
    erro.value = ''
  } catch (e) {
    erro.value = (e as Error).message
  }
}

async function atualizar() {
  try {
    anotacoes.value = (await axios.get('anotacao')).data
    erro.value = ''
  } catch (e) {
    erro.value = (e as Error).message
  }
}

async function pesquisar() {
  try {
    anotacoes.value = (
      await axios.get('anotacao/' + nomeUsuario.value + '/' + textoPesquisa.value)
    ).data
    erro.value = ''
  } catch (e) {
    erro.value = (e as Error).message
  }
}

async function incluir() {
  if (texto.value && idUsuario) {
    try {
      await axios.post('anotacao', {
        texto: texto.value,
        dataHora: dataHora.value,
        usuario: {
          id: idUsuario.value,
        },
      })
      erro.value = ''
      texto.value = ''
      dataHora.value = undefined
      idUsuario.value = undefined
      atualizar()
    } catch (e) {
      erro.value = (e as Error).message
    }
  } else {
    erro.value = 'Texto ou usuário não preenchidos!'
  }
}

function monthDifference(date1: Date): number {
  const date2: Date = new Date()
  return (date2.getFullYear() - date1.getFullYear()) * 12 + (date2.getMonth() - date1.getMonth())
}

onMounted(() => {
  atualizar()
  buscarUsuarios()
})
</script>