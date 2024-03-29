package br.com.minhafarmacia.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.minhafarmacia.util.Util;

@XmlRootElement
@Entity(name = "USUARIO")
@SequenceGenerator(name = "USUARIO_SEQUENCE", sequenceName = "USUARIO_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQUENCE")
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Transient
	private Integer idade;
	@Column(length = 50, name = "nome", nullable = false)
	private String nome;
	@Column(length = 50, name = "email", nullable = false)
	private String email;
	@Column(length = 32, name = "senha", nullable = false)
	private String senha;
	//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario_id")

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "usuario_id")
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "usuario_id")
    private List<Receita> receitas = new ArrayList<Receita>();
	
	@Transient
	private String foto;
	@Column(name = "foto")
	private byte[] fotoByte;
	@Column(name="id_facebook", length = 20)
	private String idFacebook;
	@Transient
	private String dataNascimentoString;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable =false)
	private Date dataNascimento;
	
	@Column(length = 10, name = "sexo", nullable = false)
	private String sexo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	
	
	public Usuario() {
	}
	public Usuario(String email){
		setEmail(email);
	}
	public Usuario(String nome, String email, String senha,String foto, byte[] fotoByte,List<Medicamento> medicamentos, List<Receita> receitas){
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setFoto(foto);
		setFotoByte(fotoByte);
		setMedicamentos(medicamentos);
		setReceitas(receitas);
	}
	
	
	
	public List<Receita> getReceitas() {
		return receitas;
	}
	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Nome: "+getNome()+" Email: "+getEmail()+" Senha: "+getSenha()+"\n Foto "+getFotoByte()+"Sexo "+getSexo()+" data "+getDataNascimento()+"\n meedicamentos "+getMedicamentos();
	}
//	public byte[] getFoto() {
//		return foto;
//	}
//	public void setFoto(byte[] foto) {
//		this.foto = foto;
//	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public byte[] getFotoByte() {
		return fotoByte;
	}
	public void setFotoByte(byte[] fotoByte) {
		this.fotoByte = fotoByte;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getIdFacebook() {
		return idFacebook;
	}
	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	public String getDataNascimentoString() {
//		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//		Date dataNascimentoCorreto = new Date();
//		try {
//			dataNascimentoCorreto = (Date)formatter.parse(dataNascimento);
//			System.out.println("--->"+dataNascimentoCorreto);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return dataNascimentoString;
	}
	public void setDataNascimentoString(String dataNascimentoString) {
		if(dataNascimentoString.length() >= 24)
			setDataNascimento(Util.converteStringToDate(Util.trataStringDataFormatoAmericano(dataNascimentoString)));
		else
			setDataNascimento(Util.converteStringToDate(Util.trataDataPadraoString(dataNascimentoString)));
		this.dataNascimentoString = dataNascimentoString;
	}
	
	
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		
//		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//		Date dataNascimentoCorreto = new Date();
//		try {
//			dataNascimentoCorreto = (Date)formatter.parse(dataNascimento);
//			System.out.println("--->"+dataNascimentoCorreto);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.dataNascimento = dataNascimento;
	}
	

	

	
}
