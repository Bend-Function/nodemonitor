# Node Monitor API Document

> version 0.0.1 by Bend-Function

## return data
Use JSON format to return data and status.
#### Example
>{code:200, msg: 'Success', data: [{null}]

| Return arguments |type | Description |
| ----------- | ----------- | ---- |
| code | int |Using HTTP status code |
| msg | String |Specific error or "Success" |
| data | Object | Petitionary data |


## All API urls

```
GET /info/get/{id}
POST /info/update
GET /server/getall
GET /server/getone/{id}
```

## API usage

### Get a server info
```html
GET /info/get/{id}
```
#### Request arguments
| property| type | not null |Description |
| ------- | ---- | -------- |----------- |
| id | int| Yes |Server's id |

#### Return arguments

| property| type | Description |
| ------- | ---- | --------|
| code | int | Using HTTP status code |
| msg | String | Specific error or "Success" |
| data | Object | Petitionary data |

| msg value| Description |
|----------- | ----------- |
| success| Getting data successfully|
| Not found | Can't found data in info table|

#### Example
```
https://127.0.0.1/info/get/2
```

```
return: pass
```


### Update a server info
```
POST /info/update
```

#### Post arguments

| Post arguments | type | Description |
| ------- | ----| --------|
| A Json| json| Include server status|

> Http headers must have ['Content-Type': 'application/json;charset=UTF-8']

#### Post JSON format

| Json arguments | type | Description |
| ------- | ----| --------|
| serverId| int| Server's id|
| cpu| float| CPU usage(%) |
| memory| float| Memory usage(%) |
| netout| float| Netout(TX) (Mbps) |
| netin| float| Netin(RX) (Mbps) |
| ping| float| Ping delay (ms) |
| pwd| String| Password for this server|

#### Example

>POST http://127.0.0.1/info/updete
```
POST JSON:
{
    "serverId": 1,
    "cpu": 92.44,
    "memory": 124,
    "netOut": 56.5,
    "netIn": 53.3,
    "ping": 223,
    "pwd": 123
}
```
