# Chesse and Grill - Fast Food Delivery App 🍔📱
Proyecto desarrollado como parte del curso **Desarrollo de Aplicaciones Móviles I**.

## 📲 Descripción
*Chesse and Grill* es una aplicación de delivery de comida rápida que permite:

- Registro e inicio de sesión de usuarios
- Visualización del menú con imágenes y precios
- Interfaz responsiva desarrollada en Android Studio

## 🛠️ Tecnologías utilizadas

- **Android Studio**
- **Java** / Kotlin
- **XML** para la interfaz de usuario
- **SQLite** para la persistencia local de datos
- Componentes: `RecyclerView`, `CardView`, `SQLiteOpenHelper`, `SharedPreferences`, etc.


## 📦 Estructura del proyecto

ChesseAndGrillApp/
├── app/
│ ├── java/
│ └── res/
│ ├── layout/
│ ├── drawable/
│ └── values/
├── build.gradle
└── README.md

## Para visualizar los datos guardados:
1. Ejecuta la app en el emulador.
2. Ve a Device File Explorer (en Android Studio).
3. Navega a:
      /data/data/tu.paquete/databases/mi_base_datos.db
4. Cópiala a tu PC y ábrela con DB Browser for SQLite o alguna herramienta similar.