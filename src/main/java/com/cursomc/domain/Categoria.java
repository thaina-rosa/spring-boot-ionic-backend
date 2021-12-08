package com.cursomc.domain;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;


@Entity
    public class Categoria implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotEmpty(message = "Preenchimento obrigatório")
        @Length(min = 5, max = 80, message = "O tamanho permitido deve ser entre 5 e 80 caracteres")
        private String name;

        @ManyToMany(mappedBy = "categorias")
        private List<Produto> produtos = new ArrayList<>();

        public Categoria() {

        }


        public Categoria(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Produto> getProdutos() {
            return produtos;
        }

        public void setProdutos(List<Produto> produtos) {
            this.produtos = produtos;


        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Categoria categoria = (Categoria) o;
            return Objects.equals(id, categoria.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }