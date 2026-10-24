package cl.checkpoint.biblioteca.controller;

import cl.checkpoint.biblioteca.model.Material;
import cl.checkpoint.biblioteca.service.MaterialService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {
    private final MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @GetMapping
    public List<Material> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Material obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Material crear(@RequestBody Material item) {
        return service.crear(item);
    }

    @PutMapping("/{id}")
    public Material actualizar(@PathVariable Long id, @RequestBody Material item) {
        return service.actualizar(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @PatchMapping("/{id}/prestar")
    public Material prestar(@PathVariable Long id) {
        return service.prestar(id);
    }

    @PatchMapping("/{id}/devolver")
    public Material devolver(@PathVariable Long id) {
        return service.devolver(id);
    }
}
