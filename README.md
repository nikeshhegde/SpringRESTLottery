# SpringRESTLottery

REST Implmentation

Problem
We are looking for a REST interface to a simple lottery system. The rules of the game are
described below.

Lottery Rules
You have a series of lines on a ticket with 3 numbers, each of which has a value of 0, 1, or
2. For each ticket if the sum of the values on a line is 2, the result for that line is 10.
Otherwise if they are all the same, the result is 5. Otherwise so long as both 2nd and 3rd
numbers are different from the 1st, the result is 1. Otherwise the result is 0.

Implementation
Implement a REST interface to generate a ticket with n lines. Additionally we will need to
have the ability to check the status of lines on a ticket. We would like the lines sorted into
outcomes before being returned. It should be possible for a ticket to be amended with n
additional lines. Once the status of a ticket has been checked it should not be possible to
amend. We would like tested, clean code to be returned.

Potential Solution
/ticket POST Create a ticket
/ticket GET Return list of tickets
/ticket/{id} GET Get individual ticket
/ticket/{id} PUT Amend ticket lines
/status/{id} PUT Retrieve status of ticket


# How to run this project
## Step 1)
The project requires Java and Maven installed in order to run
Java SE Development Kit 8 (1.8.0) or latest

Run this command in your terminal to see what version you have setup
```bash
java -version
```

Maven 3.0 or latest

Run this command in your terminal to see what version you have setup
```bash
mvn -version
```

## Step 2)
Download the project using git commands or as .zip and extract the project

## Step 3)

Once you have the project, using your terminal navigate to its root folder (containing "README.md","pom.xml" file)
Now run this command: 
```bash
mvn clean install
```
This will use Maven to download the required dependencies, and build an executable jar file in the newly created "target" folder

## Step 4)

You can now execute the project by navigating inside the target folder and running this command

```bash
java -jar target/lottery.jar
```

Request and response for api calls
/ticket POST Create a ticket
```bash
Create Lottery Ticket API
This API supports HTTP POST Method Only.
It is used to create a Lottery Ticket.
This API must contain lineNumbers as value to create n lines
Example:
Request -> http://localhost:8080/lottery/ticket/create?lineNumbers=1

Response:
{
  "lines": [
      {
          "lineNumbers": [
              1,
              1,
              1
          ]
      }
  ],
  "checkedStatus": false,
  "id": 1
}
```

/ticket GET Return list of tickets
```bash
Get list of all tickets
This API supports HTTP GET Method Only.
Example : http://localhost:8080/lottery/ticket/read

Response:
[
    {
        "lines": [
            {
                "lineNumbers": [
                    1,
                    1,
                    1
                ]
            }
        ],
        "checkedStatus": false,
        "id": 1
    }
]
```

/ticket/{id} GET Get individual ticket
```bash
Get ticket by id
This API supports HTTP GET Method Only.

Example : http://localhost:8080/lottery/ticket?ticketId=1

Response 
{
    "lines": [
        {
            "lineNumbers": [
                1,
                1,
                1
            ]
        }
    ],
    "checkedStatus": false,
    "id": 1
}
```

/ticket/{id} PUT Amend ticket lines
```bash
Update ticket lines
This API supports HTTP PUT Method Only.
This API must contain lineNumbers as value to create n lines and ticketId
This will not be allowed when the status has been checked for the particular id
Example : http://localhost:8080/lottery/ticket/update?ticketId=1&lineNumbers=2

Response
{
    "lines": [
        {
            "lineNumbers": [
                1,
                1,
                1
            ]
        },
        {
            "lineNumbers": [
                0,
                0,
                0
            ]
        },
        {
            "lineNumbers": [
                2,
                2,
                2
            ]
        }
    ],
    "checkedStatus": false,
    "id": 1
}
```

/status/{id} PUT Retrieve status of ticket
```bash
Check the status of the ticket
This API supports HTTP PUT Method Only.
This API must contain value ticketId to be passed for the status to be checked

Example: http://localhost:8080/lottery/ticket/status?ticketId=1

Response:
{
    "results": [
        {
            "lotteryLine": {
                "lineNumbers": [
                    1,
                    1,
                    1
                ]
            },
            "lotteryLineValue": 5
        },
        {
            "lotteryLine": {
                "lineNumbers": [
                    0,
                    0,
                    0
                ]
            },
            "lotteryLineValue": 5
        },
        {
            "lotteryLine": {
                "lineNumbers": [
                    2,
                    2,
                    2
                ]
            },
            "lotteryLineValue": 5
        }
    ]
}
```


# How to test this project

Make sure you are in root folder (containing "README.md","pom.xml" file)
Run this command in the terminal to test using JUnit Test Cases
```bash
mvn test
```

## Author
Nikesh Hegde

