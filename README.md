# Recycling Education Platform Documentation

## **Technologies Used**
- **Spring Boot**: For building the application framework.
- **Spring Data JPA**: For database interactions.
- **Swagger**: For API documentation and testing.
- **Jakarta Validation**: For input validation.
- **Maven**: For dependency management and build automation.

---

## **Setup & Installation**

### **Prerequisites**
- **JDK**: Version 17 or higher.
- **Maven**: Version 3.6 or higher (for building the project).
- **H2 Database**: Embedded database, no separate installation required.
- **Swagger UI**: Access Swagger UI for API testing at [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/).

---

## **API Endpoints**

### **1. Waste Products**
- **GET** `/api/v1/products`: Get all waste products.
- **GET** `/api/v1/products/{wasteProduct_id}`: Get a waste product by its ID.
- **GET** `/api/v1/products/categories/{wasteCategory_id}`: Get waste products by category.
- **POST** `/api/v1/products/categories/{category_id}`: Add a new waste product.
- **POST** `/api/v1/products/sort`: Sort waste products based on user-provided criteria.
- **DELETE** `/api/v1/products/{product_id}`: Delete a waste product by ID.

### **2. Waste Categories**
- **GET** `/api/v1/categories`: Get all waste categories.
- **GET** `/api/v1/categories/{wasteCategory_Id}`: Get a specific waste category by ID.
- **POST** `/api/v1/categories`: Create a new waste category.
- **PUT** `/api/v1/categories/{wasteCategory_id}`: Update an existing waste category by ID.
- **DELETE** `/api/v1/categories/{wasteCategory_Id}`: Delete a waste category by ID.

### **3. Recycle Tips**
- **GET** `/api/v1/recycle-tips`: Get all recycling tips.
- **GET** `/api/v1/recycle-tips/{Tip_id}`: Get a recycling tip by ID.
- **GET** `/api/v1/recycle-tips/active/{date}`: Get active tips from a given date.
- **POST** `/api/v1/recycle-tips`: Add a new recycling tip.
- **DELETE** `/api/v1/recycle-tips/{recycleTip_id}`: Delete a recycling tip by ID.
- **PUT** `/api/v1/recycle-tips/{recycleTip_id}`: Update an existing recycling tip.

### **4. Disposal Guidelines**
- **POST** `/api/v1/disposal-guidelines/waste-categories/{wasteCategory_Id}`: Add a new disposal guideline for a waste category.
- **GET** `/api/v1/disposal-guidelines`: Get all disposal guidelines.
- **GET** `/api/v1/disposal-guidelines/{disposalGuideline_Id}`: Get a disposal guideline by ID.
- **GET** `/api/v1/disposal-guidelines/waste-categories/{wasteCategory_Id}`: Get disposal guidelines for a waste category.
- **DELETE** `/api/v1/disposal-guidelines/{disposalGuideline_Id}`: Delete a disposal guideline by ID.
- **PUT** `/api/v1/disposal-guidelines/{guideline_id}`: Update an existing disposal guideline.

---

This documentation provides a clear overview of the technologies, setup, and API endpoints for the recycling education platform. For further details or issues, refer to the Swagger UI or the project’s codebase.

