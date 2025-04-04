import React, {JSX, useEffect, useState} from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
  TextInput,
  Alert,
  Image,
} from 'react-native';
import axios from 'axios';

type User = {
  id: number;
  nome: string;
  senha: string;
};

function App(): JSX.Element {
  const [data, setData] = useState<User[]>();

  const [nome, setNome] = useState('');
  const [senha, setSenha] = useState('');

  async function fetchData() {
    try {
      const response = await axios.get('http://10.0.2.2:8080/usuario');
      setData(response.data);
    } catch (error) {
      console.error('Erro ao buscar usuários:', error);
    }
  }

  useEffect(() => {
    fetchData();
  }, []);

  async function CadastrarUsuario() {
    try {
      const response = await axios.post('http://10.0.2.2:8080/usuario', {
        nome: nome,
        senha: senha,
      });

      console.log('Usuário cadastrado:', response.data);

      setNome('');
      setSenha('');
      Alert.alert('Usuário cadastrado com sucesso!');

      await fetchData();
    } catch (error) {
      console.error('Erro ao cadastrar usuário:', error);
      Alert.alert('Erro ao cadastrar usuário');
    }
  }

  return (
    <View style={style.container}>
      <View style={style.header}>
        <Image source={require('./user.png')} style={style.image} />
      </View>
      <View style={style.form}>
        <TextInput
          style={style.input}
          placeholder="Nome"
          value={nome}
          keyboardType="default"
          onChangeText={setNome}
        />
        <TextInput
          style={style.input}
          placeholder="Senha"
          value={senha}
          keyboardType="visible-password"
          onChangeText={setSenha}
        />
        <TouchableOpacity style={style.button} onPress={CadastrarUsuario}>
          <Text style={style.textButton}>Cadastrar novo usuário</Text>
        </TouchableOpacity>
      </View>
      <View style={style.divCardInfo}>
        {data && <Text style={style.titleCardInfo}>Usuários</Text>}
        <ScrollView>
          {data &&
            data.map(item => (
              <View style={style.cardInfo}>
                <View style={style.cardInfoDetails}>
                  <Text key={item.id} style={style.titleCardInfoDetails}>
                    Nome:
                  </Text>
                  <Text style={style.textCardInfoDetails}>{item.nome}</Text>
                </View>
                <View style={style.cardInfoDetails}>
                  <Text style={style.titleCardInfoDetails}>Senha:</Text>
                  <Text style={style.textCardInfoDetails}>{item.senha}</Text>
                </View>
              </View>
            ))}
          {!data && (
            <View style={[style.cardInfo, {borderBottomWidth: 0}]}>
              <Text
                style={[
                  style.textCardInfoDetails,
                  {
                    lineHeight: 24,
                  },
                ]}>
                Ocorreu um erro ao se conectar com o banco de dados. Tente
                novamente mais tarde!
              </Text>
            </View>
          )}
        </ScrollView>
      </View>
    </View>
  );
}

export default App;

const style = StyleSheet.create({
  container: {
    display: 'flex',
    gap: 32,
    flex: 1,
    backgroundColor: '#191919',
    paddingTop: 80,
    paddingHorizontal: 16,
  },
  header: {
    width: '100%',
    height: 300,
    borderRadius: 16,
  },
  image: {
    width: '100%',
    height: '100%',
    resizeMode: 'cover',
    opacity: 0.5,
    borderRadius: 16,
  },
  form: {},
  input: {
    width: '100%',
    backgroundColor: '#FFFFFF',
    borderRadius: 8,
    marginBottom: 16,
    paddingHorizontal: 16,
    paddingVertical: 16,
  },
  button: {
    width: '100%',
    paddingVertical: 16,
    backgroundColor: '#50A61C4D',
    borderRadius: 8,
  },
  textButton: {
    fontWeight: 'bold',
    fontSize: 16,
    color: '#FFFFFF',
    textAlign: 'center',
  },
  divCardInfo: {
    display: 'flex',
    flexDirection: 'column',
    gap: 8,
    padding: 8,
    borderRadius: 8,
  },
  titleCardInfo: {
    fontWeight: 'bold',
    fontSize: 24,
    color: '#FFFFFF',
    marginBottom: 8,
    borderRadius: 8,
  },
  cardInfo: {
    width: '100%',
    paddingVertical: 16,
    borderBottomWidth: 2,
    borderColor: '#FFFFFF',
    paddingHorizontal: 16,
    gap: 8,
  },
  cardInfoDetails: {
    display: 'flex',
    flexDirection: 'row',
    gap: 8,
    alignItems: 'center',
  },
  titleCardInfoDetails: {
    fontWeight: 'bold',
    fontSize: 18,
    color: '#FFFFFF',
  },
  textCardInfoDetails: {
    fontSize: 16,
    color: '#FFFFFF',
  },
});
