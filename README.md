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
![addnewplot](https://user-images.githubusercontent.com/89645923/195608737-9c596d90-d7d8-46f3-ab64-4ee884bb7115.PNG)


2- configure plot
![Configure](https://user-images.githubusercontent.com/89645923/195608797-89907915-b917-49b2-9227-0879a9b389b7.PNG)


3- edit plot
![edit](https://user-images.githubusercontent.com/89645923/195608851-a0a1098e-8957-4ed0-a0e5-ad1beaabab06.PNG)

4- get all plot of lands
![getall plots](https://user-images.githubusercontent.com/89645923/195608890-a863b288-de55-4657-b909-99adfd882ffa.PNG)
