 package br.com.minhafarmacia.teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.minhafarmacia.beans.Dosagem;
import br.com.minhafarmacia.beans.Medicamento;
import br.com.minhafarmacia.beans.Receita;
import br.com.minhafarmacia.beans.Usuario;
import br.com.minhafarmacia.dao.MedicamentoDAO;
import br.com.minhafarmacia.dao.ReceitaDAO;
import br.com.minhafarmacia.dao.UsuarioDAO;
import br.com.minhafarmacia.util.Util;

public class TesteBanco {

	public static void main(String[] args) {
		// System.out.println("inicio");
		// Usuario u = new Usuario();
		// u.setNome("Anna");
		// u.setDataCadastro(new Date());
		// u.setFoto("-");
		// u.setIdade(21);
		// u.setIdFacebook("idFace");
		// u.setSenha("34521");
		// u.setSexo("Feminino");
		// byte []byt = null;
		// u.setFotoByte(byt);
		// u.setEmail("annaluisa@gmail.com");
		// //
		// //System.out.println(Util.trataDataPadraoString("1 de mar de 1998"));
		// u.setDataNascimento(Util.converteStringToDate(Util.trataDataPadraoString("1
		// de mar de 1998")));
		//// System.out.println("fim");
		// new UsuarioDAO().inseirUsuario(u);
		// //System.out.println(new
		// UsuarioDAO().verificaExistencia("annaluisa@gmail.com"));
		// //System.out.println(new UsuarioDAO().fazLogin("kleiton@gmail.com",
		// "q123"));
		// // u = new UsuarioDAO().buscaUsuarioEmail("kleiton");
		// //System.out.println(u);
		//// try {
		//// converteByteArrayToFile(u.getFotoByte());
		//// } catch (FileNotFoundException e) {
		//// // TODO Auto-generated catch block
		//// e.printStackTrace();
		//// } catch (IOException e) {
		//// // TODO Auto-generated catch block
		//// e.printStackTrace();
		//// }
		//inserir();
		//testeAtualizacao();
	//testeBuscar();
		//testeBuscaEmail("kleiton@gmail.com");
		//testeBuscaMedicamentos();
	//buscaUsuarioId();
		//testeBuscaMedicamentoIdUsuario();
		//testeBanco();
		//fazLogin();
//		System.out.println(Util.converteStringToDate("24/01/2016 02:34"));
		//System.out.println(Util.trataDataPadraoString("4 de set de 2016 02:08"));
		//testeBuscarIdFaceboook();
		//testeBuscaEmail("dina@gmail.com");
		//atualizarNomeUsuario();
		//System.out.println(Util.trataTamanhoString("2016-10-19 03:55:37 +0000", 0, 16));
//		Receita r = new Receita();
//		r.setDataCadastroReceitaString("2016-10-19 03:55");
//		System.out.println("--->"+r.getDataCadastroReceita());
//		System.out.println(Util.trataStringDataFormatoAmericano("2016-10-19 03:55"));
		
//		if(Util.verificaPrimeiraLetra("+2016-10-25 23:50:00 +0000")){
//			System.out.println(Util.trataDataAmericanoPadrao("+2016-10-25 23:50:00 +0000"));
//		}
		testaBuscaReceita();
	}
	public static void testaBuscaReceita(){
		ReceitaDAO rdao = new ReceitaDAO();
		rdao.deletaReceita(rdao.buscaReceitaId(2));
	}
	public static void atualizarNomeUsuario(){
		UsuarioDAO d = new UsuarioDAO();
		Usuario u = d.buscaUsuarioEmail("anna@gmail.com");
		u.setNome("Anna Luisa T. R.");
		d.atualizaNomeUsuario(u);
		System.out.println("-----> "+d.buscaUsuarioEmail("anna@gmail.com").getNome()+" Nome");
		System.out.println(u);
		
	}
	public static void testeBuscarIdFaceboook(){
		UsuarioDAO d = new UsuarioDAO();
		System.out.println(d.buscaUsuarioIdFacebook("facebook1234"));
	}
	public static void testeBanco(){
		
		Usuario u = new Usuario();
		u.setNome("Dina");
		u.setEmail("anna@gmail.com");
		u.setSenha("1234");
		u.setIdFacebook("facebook1234");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_UNIT");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();    
		manager.persist(u);
		manager.getTransaction().commit();
	}
	public static void fazLogin(){
		System.out.println(new UsuarioDAO().fazLogin("kleiton.a.batista@gmail.com", "1234"));
	}
	public static void buscaUsuarioId(){
		System.out.println(new UsuarioDAO().buscaUsurioId(1));
	}
	public static void testeBuscaMedicamentoIdUsuario(){
		System.out.println(new MedicamentoDAO().buscaTodosMedicaemntosUsuarioId(1));
	}
	public static void testeBuscaMedicamentos(){
		System.out.println(new MedicamentoDAO().buscaTodosMedicamentosUsuario("kleiton.a.batista@gmail.com"));
	}
	public static void testeBuscaEmail(String email){
		System.out.println(new UsuarioDAO().buscaUsuarioEmail(email));
	}
	public static void testeBuscar(){
		UsuarioDAO udao = new UsuarioDAO();
		System.out.println("----->"+udao.fazLogin("kleiton.a.batista@gmail.com", "1234")+"<-----");
	}
	public static void testeAtualizacao() {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario u = udao.fazLogin("kleiton.a.batista@gmail.com", "1234");
		System.out.println("--->"+u);
		Medicamento m = new Medicamento();
		m.setApresentacao("Dorflex 25 mg");
		m.setClasseTerapeutica("Dores diversas");
		m.setCodigoBarras("0987654321");
		m.setLaboratorio("inter-life");
		m.setNomeProduto("Dorflex");
		m.setPrincipioAtivo("principio de dorflex");
		List<Medicamento> ms =  u.getMedicamentos();
		ms.add(m);
		u.setMedicamentos(ms);
		udao.atualizarUsuario(u);
	}
	public static void inserir(){
		Usuario u = new Usuario();
		u.setNome("kleiton");
		u.setEmail("kleiton.a.batista@gmail.com");
		u.setSenha("1234");
		u.setSexo("masculino");
		u.setDataCadastro(new Date());
		u.setDataNascimento(new Date());
		//u.setDataNascimentoString(new Date().toString());
		//u.setDataNascimento(new Util().converteStringToDate(u.getDataNascimentoString()));
		Dosagem d = new Dosagem();
		//d.setDataInicio("hoje");
		d.setIntervalo(8);
		d.setPeriodo(45);
		d.setQuantidade(20D);
		d.setTipo("ml");
		Medicamento m = new Medicamento();
		m.setApresentacao("Ibuprofeno 25MG");
		m.setCodigoBarras("12345633");
		m.setNomeProduto("Ibuprofeno");
		m.setDosagem(d);
		ArrayList<Medicamento> ms = new ArrayList<>();
		ms.add(m);
		u.setMedicamentos(ms);
		new UsuarioDAO().inseirUsuario(u);
	}

	public static void converteByteArrayToFile(byte[] bytes) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(new File("/Users/kleitonbatista/Desktop/img2.pdf"));
		fos.write(bytes);
		fos = new FileOutputStream(new File("/Users/kleitonbatista/Desktop/img2.png"));
		fos.write(bytes);
		fos = new FileOutputStream(new File("/Users/kleitonbatista/Desktop/img2.jpg"));
		fos.write(bytes);
		fos = new FileOutputStream(new File("/Users/kleitonbatista/Desktop/img2.jpeg"));
		fos.write(bytes);
	}
}
