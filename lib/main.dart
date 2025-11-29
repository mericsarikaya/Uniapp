import 'package:flutter/material.dart';

void main() {
  runApp(UniApp());
}

class UniApp extends StatelessWidget{
  const UniApp({super.key});

@override
Widget build(BuildContext context){
  return MaterialApp(
  home: Scaffold(
  appBar: AppBar(
  title: Text("UniApp"),
  backgroundColor: Colors.indigo.shade200,
  centerTitle: true,
),
body: Image.asset("assets/images/logo.png"),
),
);
}




}
