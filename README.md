# Awesome REST API example

This is an example of some REST API

# Running in development

```
git clone https://github.com/pshvets/REST-API.git
cd REST-API/
./gradlew bootRun
```

# Base Path
```
http://localhost:8080/api/v1/users
```

# Methods
## Create User
```
POST /createUser
```
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

```
GET /api/v1/users/getUser/{some_id}
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
```
GET /api/v1/users/{some_id}/delete
```
 Response Example

```
200 OK
```
## Update User
```
POST /{some_id}/update
```
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