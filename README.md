# Awesome REST API example

This is an example of some REST API

# Running in development

```
git pull
./gradlew clean build bootRun
```

# Base Path
```
http://localhost:8080/api/v1/users
```

# Request Example
```
{
  "name": "your_name",
  "email": "your_email"
}
```

# Response Example

```
{
  "id": "some_id",
  "name": "your_name",
  "email": "your_email"
}
```

# Methods
## Create User
```
POST /createUser
```
## Get User
```
GET /getUser/{id}
```
## Get All User
```
GET /getUsers
```
## Delete User
```
DELETE /{id}/delete
```
## Update User
```
POST /{id}/update
```