# IFGTest

Bangun layanan yang menerima data dari Kafka topic, melakukan manipulasi data, dan menulisnya kembali ke Kafka atau menyimpannya ke database.

Menggunakan tech stack: 
Programming Language: Java 17;
Framework: Quarkus;

Dikirim ke email ruchi@ifg-life.id , rana.dewadatta@ifg-life.id, via gitlab dibuat public jangan di private dan ditunggu 1x24 jam

Saya memutuskan untuk membuat Transaction Withdrawl dan deposit yang nantinya akan mempengaruhi Balance Account (Tapi Cuman simple ya. jangan berharap banyak bang! Ahaha)

## Tools

```
Java 17
Quarkus 3.18.4
Kafka local
postgreSql
```

> **_NOTE:_**  Mode devservices docker dimatikan.

## Running App 

1. Pastikan Zookeeper & Kafka server berjalan.
2. Running Quarkus starting dengan setting
   ```
   #Boot awal untuk creating table
   quarkus.hibernate-orm.database.generation=create

   Noted :
   jika sudah berjalan bisa di rubah ke generation=update/none
   ```
3. Jalankan script DML yang terdapat pada additional SQL manual by db
4. Create pada kafka dua topic berikut : topic test (Consumer) & ifg-topic (Produser) //Setting simple tanpa partition

## Json Request API

```
{
  "transactionId": "TX789012",
  "userId": 1,
  "amount": 250000.00,
  "currency": "IDR",
  "timeTransaction": "2025-02-21 15:30:00",
  "transactionType": "DEPOSIT",
  "transactionDirection": "DEBIT",
  "status": "PENDING",
  "description": "Payment for invoice INV-20250221"
}
```

## Json Kafka
```
{"transactionId": "TX789014", "userId": 1, "amount": 250000.00, "currency": "IDR", "timeTransaction": "2025-02-21 15:30:00", "transactionType": "DEPOSIT", "transactionDirection": "DEBIT", "status": "PENDING", "description": "Payment for invoice INV-20250224"}
```
## Success Response
```
{
    "status": "SUCCESS",
    "code": 200,
    "message": "Transaction successful",
    "data": {
        "transactionId": "TX789014",
        "userId": 1,
        "amount": 250000.00,
        "currency": "IDR",
        "transactionType": "DEPOSIT",
        "processAt": "2025-02-21 12:42:27.9470014",
        "status": "COMPLETED"
    }
}
  ```

## Failed Response Disesuaikan dengan Exception
```
{
    "error": "Json body is not valid",
    "message": "transactionProcess.requestDto.transactionId: Transaction Id can't empty!, transactionProcess.requestDto.userId: User Id can't empty!"
}
```


### REST API Test

```
@POST
@Path("/big-bang")
public Response transactionProcess(@Valid TransactionRequestDto requestDto) throws ParseException, JsonProcessingException {
    return Response.status(Response.Status.OK)
            .entity(new GlobalSuccessResponseDto<>(Constant.SUCCESS_STATUS, transactionService.transactionProcess(requestDto)))
            .build();
}
```

## Conclution

Quarkus adalah framework yang sangat cepat dan efisien untuk pengembangan aplikasi, khususnya untuk arsitektur mikroservis dengan berbagai fitur built-in. Penggunaan Kafka, validasi data, dan pengolahan transaksi bisa dilakukan dengan lancar di Quarkus, dan integrasi dengan pustaka eksternal seperti Lombok mempermudah pengembangan kode yang lebih bersih dan efisien.

Kendala susah susahnya ga boleh di ceritain ahaha ``) Terima gajah!! 
