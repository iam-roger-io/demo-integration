package com.redhat.consulting.fuse.model;

import java.io.Serializable;

public class PersonModel implements Serializable {

	private static final long serialVersionUID = 6932170202779243732L;

	private String _id;
	private String nome;
	private String email;
	private String cpf;
	private String celular;
	private String endereco;
	private String complemento;
	private String cidade;
	private String uf;
	private String cep;
	private String pais;

	public PersonModel() {
	}

	public PersonModel(Object id, Object nome, Object email, Object cpf, Object celular, Object endereco,
			Object complemento, Object cidade, Object uf, Object cep, Object pais) {
		super();
		this._id = id.toString();

		if (null != nome) {
			this.nome = nome.toString();
		}

		if (null != email) {
			this.email = email.toString();
		}

		if (null != cpf) {
			this.cpf = cpf.toString();
		}

		if (null != celular) {
			this.celular = celular.toString();
		}

		if (null != endereco) {
			this.endereco = endereco.toString();
		}

		if (null != complemento) {
			this.complemento = complemento.toString();
		}

		if (null != cidade) {
			this.cidade = cidade.toString();
		}

		if (null != uf) {
			this.uf = uf.toString();
		}

		if (null != cep) {
			this.cep = cep.toString();
		}

		if (null != pais) {
			this.pais = pais.toString();
		}
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String id) {
		this._id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "PersonModel [_id=" + _id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", celular="
				+ celular + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", uf="
				+ uf + ", cep=" + cep + ", pais=" + pais + "]";
	}
	
	

}
