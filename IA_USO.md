# Uso de Inteligencia Artificial en el Desarrollo

## Prompt 1
**Descripción**: Se solicitó crear las clases Java para la capa "Entidades" del sistema de control de acceso a laboratorio, incluyendo Usuario y Acceso con atributos, constructores, getters/setters, toString() y fromString().

**Parte del sistema resuelta**: Capa de entidades (Usuario.java, Acceso.java).

**Ajustes realizados manualmente**:

**Justificación técnica**: Las entidades definen el modelo de datos del dominio, encapsulando atributos y comportamientos básicos como serialización para persistencia en archivos .txt.

## Prompt 2
**Descripción**: Se pidió implementar la capa "AccesoDatos" con UsuarioDAO y AccesoDAO, utilizando archivos .txt para persistencia, con métodos CRUD y manejo de excepciones.

**Parte del sistema resuelta**: Capa de acceso a datos (UsuarioDAO.java, AccesoDAO.java).

**Ajustes realizados manualmente**:

**Justificación técnica**: La capa DAO abstrae el acceso a datos, permitiendo cambios en la persistencia sin afectar otras capas, y maneja excepciones para robustez.

## Prompt 3
**Descripción**: Se requirió crear la capa "LogicaNegocio" con LaboratorioServicio, incluyendo métodos para gestión de usuarios y accesos, con validaciones y llamadas a DAOs.

**Parte del sistema resuelta**: Capa de lógica de negocio (LaboratorioServicio.java).

**Ajustes realizados manualmente**:

**Justificación técnica**: Centraliza la lógica de negocio, valida reglas y coordina entre presentación y datos, manteniendo separación de responsabilidades.

## Prompt 4
**Descripción**: Se solicitó implementar la capa "Presentacion" con una clase Main que incluye un menú interactivo en consola usando Scanner, llamando solo a LaboratorioServicio.

**Parte del sistema resuelta**: Capa de presentación (Main.java).

**Ajustes realizados manualmente**:

**Justificación técnica**: La interfaz de usuario se mantiene simple y desacoplada, delegando lógica a servicios, facilitando cambios en la UI sin afectar negocio.

## Prompt 5
**Descripción**: Se pidió revisar LaboratorioServicio y agregar validaciones adicionales para entradas/salidas, rol case-insensitive y manejo de accesos incompletos.

**Parte del sistema resuelta**: Mejoras en validaciones de LaboratorioServicio.

**Ajustes realizados manualmente**:

**Justificación técnica**: Las validaciones fortalecen la integridad de datos y previenen estados inconsistentes, mejorando la fiabilidad del sistema.

## Prompt 6
**Descripción**: Se requirió generar documentación para el proyecto, incluyendo README.md, CHANGELOG.md e IA_USO.md con estructura específica.

**Parte del sistema resuelta**: Documentación del proyecto (README.md, CHANGELOG.md, IA_USO.md).

**Ajustes realizados manualmente**:

**Justificación técnica**: La documentación facilita mantenimiento, comprensión y colaboración, siguiendo estándares de proyectos profesionales.