package com.practica.integracion;

import com.practica.integracion.DAO.AuthDAO;
import com.practica.integracion.DAO.GenericDAO;
import com.practica.integracion.DAO.User;
import com.practica.integracion.manager.SystemManager;
import com.practica.integracion.manager.SystemManagerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestInvalidUser {
	@Mock
	private static AuthDAO mockAuthDao;
	@Mock
	private static GenericDAO mockGenericDao;

	@DisplayName("Test start usuario inválido y filtro válido")
	@Test
	public void testStartRemoteSystemWithInvalidUserAndSystem() throws Exception {
		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		User invalidUser = new User("2","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));

		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345"; // id valido de sistema

		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
		when(mockGenericDao.getSomeData(validUser, "where id=" + validId)).thenReturn(lista);
		// primero debe ejecutarse la llamada al dao de autenticación
		// despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
		InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
		// instanciamos el manager con los mock creados
		SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
		// llamada al api a probar
		Collection<Object> retorno = manager.startRemoteSystem(invalidUser.getId(), validId);
		assertEquals(retorno.toString(), "[uno, dos]");
		// vemos si se ejecutan las llamadas a los dao, y en el orden correcto
		ordered.verify(mockAuthDao).getAuthData(validUser.getId());
		ordered.verify(mockGenericDao).getSomeData(validUser, "where id=" + validId);
	}

	@DisplayName("Test start usuario inválido y filtro inválido")
	@Test
	public void testStartRemoteSystemWithInvalidUserAndSystem2() throws Exception {

		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		User invalidUser = new User("2","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345"; // id valido de sistema
		String invalidId = "123";
		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
		when(mockGenericDao.getSomeData(validUser, "where id=" + validId)).thenReturn(lista);
		// primero debe ejecutarse la llamada al dao de autenticación
		// despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
		InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
		// instanciamos el manager con los mock creados
		SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
		// llamada al api a probar
		Collection<Object> retorno = manager.startRemoteSystem(invalidUser.getId(), invalidId);
		assertEquals(retorno.toString(), "[uno, dos]");
		// vemos si se ejecutan las llamadas a los dao, y en el orden correcto
		ordered.verify(mockAuthDao).getAuthData(validUser.getId());
		ordered.verify(mockGenericDao).getSomeData(validUser, "where id=" + validId);
	}

	@DisplayName("Test stop usuario inválido y filtro válido")
	@Test
	public void testStopRemoteSystemWithInvalidUserAndSystem() throws Exception {
		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		User invalidUser = new User("2","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));

		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345"; // id valido de sistema

		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
		when(mockGenericDao.getSomeData(validUser, "where id=" + validId)).thenReturn(lista);
		// primero debe ejecutarse la llamada al dao de autenticación
		// despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
		InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
		// instanciamos el manager con los mock creados
		SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
		// llamada al api a probar
		Collection<Object> retorno = manager.stopRemoteSystem(invalidUser.getId(), validId);
		assertEquals(retorno.toString(), "[uno, dos]");
		// vemos si se ejecutan las llamadas a los dao, y en el orden correcto
		ordered.verify(mockAuthDao).getAuthData(validUser.getId());
		ordered.verify(mockGenericDao).getSomeData(validUser, "where id=" + validId);
	}

	@DisplayName("Test stop usuario inválido y filtro inválido")
	@Test
	public void testStopRemoteSystemWithInvalidUserAndSystem2() throws Exception {

		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		User invalidUser = new User("2","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345"; // id valido de sistema
		String invalidId = "123";
		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
		when(mockGenericDao.getSomeData(validUser, "where id=" + validId)).thenReturn(lista);
		// primero debe ejecutarse la llamada al dao de autenticación
		// despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
		InOrder ordered = inOrder(mockAuthDao, mockGenericDao);
		// instanciamos el manager con los mock creados
		SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);
		// llamada al api a probar
		Collection<Object> retorno = manager.stopRemoteSystem(invalidUser.getId(), invalidId);
		assertEquals(retorno.toString(), "[uno, dos]");
		// vemos si se ejecutan las llamadas a los dao, y en el orden correcto
		ordered.verify(mockAuthDao).getAuthData(validUser.getId());
		ordered.verify(mockGenericDao).getSomeData(validUser, "where id=" + validId);
	}

	@DisplayName("Test add usuario inválido y añade correctamente")
	@Test
	public void testaddRemoteSystemWithInvalidUserAndSystem() throws Exception {
		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
		User invalidUser = new User("2","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
		when(mockGenericDao.updateSomeData(validUser, lista)).thenReturn(true);

		// primero debe ejecutarse la llamada al dao de autenticación
		// despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
		InOrder ordered = inOrder(mockAuthDao, mockGenericDao);

		// paramos el manager con los mock creados
		SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);

		// llamada al api a probar

		manager.addRemoteSystem(invalidUser.getId(), lista);

		// vemos si se ejecutan las llamadas a los dao, y en el orden correcto
		ordered.verify(mockAuthDao).getAuthData(validUser.getId());
		ordered.verify(mockGenericDao).updateSomeData(validUser, lista);
	}

	@DisplayName("Test add usuario inválido y no añade correctamente")
	@Test
	public void testaddRemoteSystemWithinvalidUserAndNoSystem() throws Exception {
		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
		User invalidUser = new User("2","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
		when(mockGenericDao.updateSomeData(validUser, lista)).thenReturn(false);

		// primero debe ejecutarse la llamada al dao de autenticación
		// despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
		InOrder ordered = inOrder(mockAuthDao, mockGenericDao);

		// paramos el manager con los mock creados
		SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);

		// llamada al api a probar

		assertThrows(SystemManagerException.class, () ->manager.addRemoteSystem(invalidUser.getId(), lista));

		// vemos si se ejecutan las llamadas a los dao, y en el orden correcto
		ordered.verify(mockAuthDao).getAuthData(validUser.getId());
		ordered.verify(mockGenericDao).updateSomeData(validUser, lista);
	}

	@DisplayName("Test delete usuario inválido y remoteId válido")
	@Test
	public void testdeleteRemoteSystemWithinvalidUserAndSystem() throws Exception {
		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
		User invalidUser = new User("2","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345"; // id valido de sistema
		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
		when(mockGenericDao.deleteSomeData(validUser, "where id=" + validId )).thenReturn(true);

		// primero debe ejecutarse la llamada al dao de autenticación
		// despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
		InOrder ordered = inOrder(mockAuthDao, mockGenericDao);

		// paramos el manager con los mock creados
		SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);

		// llamada al api a probar

		manager.deleteRemoteSystem(invalidUser.getId(), validId);

		// vemos si se ejecutan las llamadas a los dao, y en el orden correcto
		ordered.verify(mockAuthDao).getAuthData(validUser.getId());
		ordered.verify(mockGenericDao).deleteSomeData(validUser, validId);
	}

	@DisplayName("Test delete usuario inválido y no elimina correctamente")
	@Test
	public void testdeleteRemoteSystemWithinvalidUserAndNoSystem() throws Exception {
		User validUser = new User("1","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1, 2)));
		User invalidUser = new User("2","Ana","Lopez","Madrid", new ArrayList<Object>(Arrays.asList(1,2)));
		when(mockAuthDao.getAuthData(validUser.getId())).thenReturn(validUser);

		String validId = "12345"; // id valido de sistema
		String invalidId = "123";
		ArrayList<Object> lista = new ArrayList<>(Arrays.asList("uno", "dos"));
		when(mockGenericDao.deleteSomeData(validUser, "where id=" + validId )).thenReturn(true);

		// primero debe ejecutarse la llamada al dao de autenticación
		// despues el de  acceso a datos del sistema (la validaciones del orden en cada prueba)
		InOrder ordered = inOrder(mockAuthDao, mockGenericDao);

		// paramos el manager con los mock creados
		SystemManager manager = new SystemManager(mockAuthDao, mockGenericDao);

		// llamada al api a probar

		assertThrows(SystemManagerException.class, () ->manager.deleteRemoteSystem(invalidUser.getId(), invalidId));

		// vemos si se ejecutan las llamadas a los dao, y en el orden correcto
		ordered.verify(mockAuthDao).getAuthData(validUser.getId());
		ordered.verify(mockGenericDao).deleteSomeData(validUser, validId);
	}

}
