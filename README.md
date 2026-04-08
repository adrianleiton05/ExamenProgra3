# Sistema de Control de Acceso a Laboratorio

## Descripción

Este sistema permite gestionar el control de acceso a un laboratorio universitario. Incluye funcionalidades para registrar usuarios (estudiantes y docentes), gestionar entradas y salidas al laboratorio, y consultar historiales de acceso y tiempos totales de uso.

El sistema utiliza archivos de texto plano (.txt) para persistir la información, sin necesidad de bases de datos externas.

## Tecnologías

- **Java**: Versión 17
- **Persistencia**: Archivos .txt
- **Frameworks**: Ninguno (código puro Java)

## Estructura de Paquetes

- `entidades`: Clases de dominio (Usuario, Acceso)
- `accesodatos`: Capa de acceso a datos (UsuarioDAO, AccesoDAO)
- `logicadenegocio`: Lógica de negocio (LaboratorioServicio)
- `presentacion`: Interfaz de usuario (Main con menú consola)

## Instrucciones de Compilación y Ejecución

### Prerrequisitos

- Java 17 instalado y configurado en el PATH.
- Sistema operativo Windows (los comandos están adaptados para cmd).

### Compilación

1. Navega al directorio raíz del proyecto:
   ```
   cd c:\Users\ocris\Downloads\ExamenAdrianProgra3
   ```

2. Compila todas las clases Java:
   ```
   javac -d . entidades/*.java accesodatos/*.java logicadenegocio/*.java presentacion/*.java
   ```

   Esto creará los archivos .class en las carpetas correspondientes.

### Ejecución

Ejecuta la aplicación desde el directorio raíz:
```
java -cp . presentacion.Main
```

El menú interactivo se mostrará en la consola. Selecciona las opciones del 1 al 7 para interactuar con el sistema, o 0 para salir.

### Archivos Generados

- `usuarios.txt`: Almacena la información de los usuarios registrados.
- `accesos.txt`: Registra todas las entradas y salidas al laboratorio.

## Uso

El sistema ofrece un menú de consola con las siguientes opciones:

1. Registrar usuario
2. Listar usuarios
3. Eliminar usuario
4. Registrar entrada al laboratorio
5. Registrar salida del laboratorio
6. Ver historial de accesos de un usuario
7. Ver tiempo total en laboratorio de un usuario
0. Salir

Todas las validaciones de negocio se manejan automáticamente, mostrando mensajes de error cuando sea necesario.