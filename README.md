# Irrigation-System

in this project i tried to implement rest end points from my understanding to the PDF 
i was concentrated on application structure and using new features like spring data(through CRUD rebositories) 
also i used H2 DB in order for the person how will see this project can run on his machin without configuring A real DB. 

if you want to add for simplicity you can use below request 

{
  "id" : 1,
  "status" : null,
  "area" : 4.5,
  "amountOfWaterNeeded" : 3.0,
  "timeslots" : null,
  "sensor" : {
    "id" : 1,
    "status" : null
  }
}


and also below are screen shots from my testing 

![addnewplot](https://user-images.githubusercontent.com/89645923/195422819-4e4a8e75-08e0-4aed-9356-289524f43a35.PNG)
![Configure](https://user-images.githubusercontent.com/89645923/195422859-24187d3c-206a-49d9-8ea5-efc4072c9048.PNG)
![edit](https://user-images.githubusercontent.com/89645923/195422881-a161b449-0066-479f-9f32-d1289e64d807.PNG)
![getall plots](https://user-images.githubusercontent.com/89645923/195422271-f5e0f22e-573b-4019-b8e3-9f422ddac5b8.PNG)
