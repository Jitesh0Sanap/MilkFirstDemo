# MilkFirstDemo

📦 Product & Inventory Management API
A Spring Boot REST API to manage products and their inventory in a warehouse system. The API allows you to create, update, and fetch product and inventory data.

🚀 Project Setup Instructions
🔧 Requirements
Java 17+
Maven 3.8+
Spring Boot 3.x
IDE (IntelliJ)
MySQL for persistence

✅ Validation: Jakarta Bean Validation with custom messages (@NotBlank, @Size, @Positive)
✅ Global Exception Handling: Using @RestControllerAdvice
✅ DTO Layer: Clean separation between entity and DTO
✅ MySQL Database for testing
✅ Postman used to check api
✅ Java 17, Spring Boot 3.x standards
✅ used modelmapper

com.mfdemo
│
├── controller
│   ├── ProductController.java
│   └── InventoryController.java
│
├── dto
│   ├── ProductDto.java
│   └── InventoryDto.java
│
├── entity
│   ├── Product.java
│   └── Inventory.java
│
├── repository
│   ├── ProductRepository.java
│   └── InventoryRepository.java
│
├── service
│   ├── ProductService.java
│   └── InventoryService.java
│
└── exception
    └── GlobalExceptionHandler.java
