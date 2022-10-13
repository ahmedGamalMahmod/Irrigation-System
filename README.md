# Irrigation-System

In this project i tried to implement rest end points from my understanding to the PDF. 
I was concentrated on application structure and using new features like spring data(through CRUD rebositories) 
also i used H2 DB in order for the person how will see this project can run on his machin without configuring A real DB. 

if you want to test addNewPlotOfland for simplicity you can use below request 

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

1- add new plot 
![addnewplot](https://user-images.githubusercontent.com/89645923/195422819-4e4a8e75-08e0-4aed-9356-289524f43a35.PNG)

2- configure plot
![Configure](https://user-images.githubusercontent.com/89645923/195606968-df21be2e-4d39-4aab-8ba6-dfb488158102.PNG)

3- edit plot
![edit](https://user-images.githubusercontent.com/89645923/195422881-a161b449-0066-479f-9f32-d1289e64d807.PNG)

4- get all plot of lands
![getall plots](https://user-images.githubusercontent.com/89645923/195422271-f5e0f22e-573b-4019-b8e3-9f422ddac5b8.PNG)
