package com.cursomc.repositories;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer> {

    @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.name LIKE %:name% AND cat IN :categorias")
    Page<Produto> finfDistincByNameContainingAndCategoriasIn(@Param("name") String name,
                                                             @Param("categorias") List<Categoria>categorias, Pageable pageRequest);



}
