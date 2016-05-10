package es.cursillo.Controlador;

import java.util.List;

public interface DAO<Entity, I> {
	public I create(Entity bean) throws Exception;

	public I remove(I id) throws Exception;

	public I update(Entity bean) throws Exception;

	public Entity find(I id) throws Exception;

	public List<Entity> findAll(Entity bean) throws Exception;
}
