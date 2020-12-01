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

### Get a server's information
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
| data | Object | Petitionary data (Json in List)|

| msg value| Description |
|----------- | ----------- |
| success| Getting data successfully|
| Not found | Can't found data in the 'info' table|

#### Example
Request:
```
https://127.0.0.1/info/get/2
```
Return:
```
{
   "code":200,
   "msg":"success",
   "data":[
      {
         "id":7,
         "serverid":2,
         "cpu":44.0,
         "memory":342.0,
         "netout":99.0,
         "netin":87.0,
         "ping":65.0,
         "time":"2020-11-22T18:33:10"
      },
      {
         "id":2,
         "serverid":2,
         "cpu":50.0,
         "memory":354.0,
         "netout":40.23,
         "netin":65.45,
         "ping":23.0,
         "time":"2020-11-22T21:26:01"
      }
   ]
}
```


### Update a server's information
```
POST /info/update
```
Before you POST data to database, you must add a server information to 'server' table.<br>
If you don't do that, server will return 'ServerId not found'.

#### Post arguments

| Post arguments | type | Description |
| ------- | ----| --------|
| A Json| json| Include server status|

> Http headers must have ['Content-Type': 'application/json;charset=UTF-8']

#### Post JSON arguments

| Json arguments | type | default | not null| Description |
| ------- | ----| --------| --------| --------|
| serverId| int| N/A| Yes | Server's id|
| cpu| float|0| No|  CPU usage (%) |
| memory| float|0| No|  Memory usage (%) |
| netout| float|0| No|  Netout(TX) (Mbps) |
| netin| float|0| No|  Netin(RX) (Mbps) |
| ping| float|0| No|  Ping delay (ms) |
| pwd| String|N/A| Yes| Password for this server|

#### Return arguments
| property| type | Description |
| ------- | ---- | --------|
| code | int | Using HTTP status code |
| msg | String | Specific error or "Success" |
| data | null | N/A |

All return status:
```
{"code":200,"msg":"success","data":"Updated success"}
{"code":401,"msg":"Wrong Password.","data":null}
{"code":404,"msg":"ServerId not found","data":null}
```

#### Example
Request:
```
POST http://127.0.0.1/info/update
```
Return:
```
POST JSON:
{
    "serverId": 1,
    "cpu": 92.44,
    "memory": 124,
    "netout": 56.5,
    "netin": 53.3,
    "ping": 223,
    "pwd": "12a"
}
```
```$xslt
return:
{"code":200,"msg":"success","data":"Updated success"}
```

### Get servers' property
#### Get all servers' property
```
GET https://127.0.0.1/server/getall
```
#### Request arguments
Null

#### Return arguments
| property| type | Description |
| ------- | ---- | --------|
| code | int | Using HTTP status code |
| msg | String | Specific error or "Success" |
| data | Object | Petitionary data (Json in List)|
#### Example
Request:
```
GET https://127.0.0.1/server/getall
```

Return:
```
{
   "code":200,
   "msg":"success",
   "data":[
      {
         "serverdescribe":"NTT",
         "serverlocation":"HK",
         "servername":"HK1",
         "id":1
      },
      {
         "serverdescribe":"AWS",
         "serverlocation":"JP",
         "servername":"JP1",
         "id":2
      }
   ]
}
```

#### Get a server's property
```
GET /server/getone/{id}
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
| data | Object | Petitionary data (Json in List)|


| msg value| Description |
|----------- | ----------- |
| success| Getting data successfully|
| Not found | Can't found data in the 'server' table|

#### Example
Requests:
```
GET https://127.0.0.1/server/getone/1
```
Return:
```
{
   "code":200,
   "msg":"success",
   "data":[
      {
         "serverdescribe":"NTT",
         "serverlocation":"HK",
         "servername":"HK1",
         "id":1
      }
   ]
}
```
