package cl.checkpoint.biblioteca.service;

import cl.checkpoint.biblioteca.model.Material;
import cl.checkpoint.biblioteca.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository repo;

    public MaterialService(MaterialRepository repo) {
        this.repo = repo;
    }

    public List<Material> listar() {
        return repo.findAll();
    }

    public Material obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    public Material crear(Material item) {
        if (item.getDisponible() == null)
            item.setDisponible(true);
        return repo.save(item);
    }

    public Material actualizar(Long id, Material item) {
        Material actual = obtener(id);
        if (item.getTitulo() != null)
            actual.setTitulo(item.getTitulo());
        if (item.getTipo() != null)
            actual.setTipo(item.getTipo());
        if (item.getDisponible() != null)
            actual.setDisponible(item.getDisponible());
        return repo.save(actual);
    }

    public void eliminar(Long id) {
        obtener(id);
        repo.deleteById(id);
    }

    public Material prestar(Long id) {
        Material m = obtener(id);
        if (!Boolean.TRUE.equals(m.getDisponible()))
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.CONFLICT, "Material no disponible");
        m.setDisponible(false);
        return repo.save(m);
    }

    public Material devolver(Long id) {
        Material m = obtener(id);
        m.setDisponible(true);
        return repo.save(m);
    }

}
