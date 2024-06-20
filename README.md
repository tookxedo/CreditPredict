# Bangkit 2024 Capstone Team : Credit (C241-PS483)

Hello everyone!. Here is our repository Mobile Development path Team for Bangkit 2024 Capstone project. Our team consist of 3 Machine Learning, 2 Android, and 2 Cloud Computing.

## Our Knights

|            Nama             |  Bangkit-ID  |       Path       |
| :-------------------------: | :----------: | :--------------: |
|        Ariyova Banua        | M391D4KY1880 | Machine Learning |
|       Fajar Al Najiim       | M391D4KY2415 | Machine Learning |
|   Josep Daniel Simatupang   | M391D4KY2654 | Machine Learning |
|      Zaky Irsyad Rais       | C214D4KY0273 | Cloud Computing  |
|       Hanun Salsabila       |   	C183D4KX0956  | Cloud Computing  |
| Ahmad Ryan Saffah Yartavick | A548D4NY4609 |     Android      |
|       Ekasari Amalia        | A548D4NX4606 |     Android      |

## What is this project

We created a mobile application called **Credit Predict**.

**Credit Predict** is an application to predict credit card applications by customers by inputting personal data, and various other certain data. With this application, everyone can check whether their personal data such as age, work history, and so on are eligible to be approved to get a credit card application or even rejected.

## Guidance for running our model on local

Make sure you intalled all this dependencies first on your local machine. You can use conda virtual env for making things easier with pip

```text
Flask==3.0.3
Flask-Cors==4.0.1
gunicorn==22.0.0
itsdangerous==2.2.0
Jinja2==3.1.4
MarkupSafe==2.1.5
packaging==24.1
python-dotenv==1.0.1
Werkzeug>=3.0.0
tensorflow
numpy
pandas
scikit-learn
```

#### Setup Instructions
To set up the CreditPredict Android application on your development environment, follow these steps:

1. **Clone the repository**:
`git clone https://github.com/tookxedo/CreditPredict.git`

2. **Open Android Studio**:
- Navigate to `File` -> `Open` and select the `CreditPredict` directory.

3. **Build the project**:
- Once the project is loaded, Android Studio will automatically sync the project and download the necessary dependencies specified in the `build.gradle` files.

4. **Run the application**:
- Connect your Android device or use an emulator.
- Click on the "Run" button in Android Studio to build and run the application on your device.

You can also test our API [Here](https://creditapp-64tbubeb5q-et.a.run.app/predict)


## Navigation
- ### [&nbsp;&nbsp;Macine Learning](https://github.com/Jafarrrr25/CapstoneML.git)
- ### [&nbsp;&nbsp;Cloud Computing](https://github.com/zakyirsyaad/creditapp)

## How the Mobile Development works in this application
   - In Android app development, the use of ViewModel and Repository is part of the recommended architecture, commonly known as the MVVM (Model-View-ViewModel) pattern. 
     This pattern helps in separating concerns, making the codebase more modular, testable, and maintainable.
@@ -8,3 +73,10 @@

   - In conclusion, ApiService defines the API endpoints. Repository uses ApiService to fetch data and provides additional data handling logic if needed. ViewModel interacts with the Repository to fetch data. It
     exposes the fetched data to the UI through a LiveData or StateFlow.

## Project Update

**TBD**
