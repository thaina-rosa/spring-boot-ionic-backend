package com.cursomc.resources;

import com.cursomc.domain.Produto;
import com.cursomc.dto.ProdutoDTO;
import com.cursomc.repositories.utils.URL;
import com.cursomc.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping(value = "/produtos")
    public class  ProdutoResource {

        @Autowired
        private ProdutoService service;

        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        public ResponseEntity<Produto> find(@PathVariable Integer id) {
            Produto obj = service.find(id);
            return ResponseEntity.ok().body(obj);

        }
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<Page<ProdutoDTO>> findPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "categorias", defaultValue = "") String categorias,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerpage", defaultValue = "24") Integer linesPerpage,
            @RequestParam(value = "orderBy ", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
            String nameDecoded = URL.decodeParam(name);
            List<Integer> ids = URL.decodeIntList(categorias);
            Page<Produto> list = service.search(nameDecoded, ids, page, linesPerpage, orderBy, direction);
        Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }

        }
