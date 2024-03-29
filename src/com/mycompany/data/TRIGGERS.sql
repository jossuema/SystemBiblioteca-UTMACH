SELECT * FROM dblibreria.reportes;

DELIMITER //
	CREATE TRIGGER AUMENTAR_STOCK_DEVOLUCION  AFTER UPDATE ON REPORTES
    FOR EACH ROW
    BEGIN
		IF NEW.DEVUELTO = true THEN
        UPDATE LIBROS
        SET STOCK = STOCK + 1
        WHERE LIBROS.ID = NEW.IDLIBRO;
	END IF;
	END;
//

DELIMITER //
	CREATE TRIGGER REDUCIR_STOCK_PRETAMO AFTER INSERT ON REPORTES
    FOR EACH ROW
    BEGIN
		IF((SELECT STOCK FROM LIBROS WHERE ID = NEW.IDLIBRO)>0) THEN
        UPDATE LIBROS
        SET STOCK = STOCK - 1
        WHERE LIBROS.ID = NEW.IDLIBRO;
	ELSE
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'No hay suficientes libros en stock';
	END IF;
	END;
//