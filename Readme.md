# Lokasi-Android-Kotlin

Belajar mengakses koordinat latitude dan longitude di Android menggunakan bahasa Kotlin.

Untuk mengakses data koordinat, pastikan _permission_ sudah diatur.

```
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

Selain itu, pastikan juga librari yang dibutuhkan sudah dimasukkan:

```
dependencies(){
...
    implementation "com.google.android.gms:play-services-location:26.1.0"
}
```
