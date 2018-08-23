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
 Request Example
```
{
  "name": "your_name",
  "email": "your_email"
}
```
 Response Example

```
{
  "id": "some_id",
  "name": "your_name",
  "email": "your_email"
}
```

## Get User

 Request Example
```
GET /api/v1/users/getUser/some_id
```
 Response Example

```
{
  "id": "some_id",
  "name": "your_name",
  "email": "your_email"
}
```
## Get All User

 Request Example
```
GET /api/v1/users/getUsers
```
 Response Example

```
[
  {
    "id": "some_id",
    "name": "your_name",
    "email": "your_email"
  },
  {
    "id": "some_id",
    "name": "your_name",
    "email": "your_email"
  }
]
```
## Delete User
 Request Example
```
GET /api/v1/users/some_id/delete
```
 Response Example

```
200 OK
```
## Update User
```
POST /{id}/update
```
 Request Example
```
{
  "name": "your_new_name",
  "email": "your_new_email"
}
```
 Response Example

```
{
  "id": "some_id",
  "name": "your_new_name",
  "email": "your_new_email"
}
```