# Braj Bhooshan
# talkingclockserviceapi
talking clock service api

Rest APIs
1)	Talking Clock
http://localhost:8081/talkingclockserviceapi/v1/clock?time=22:30
or
http://localhost:8081/talkingclockserviceapi/v1/clock

Method: - Get

Input – With or without request parameter.
Sample Output Payload: -

{
    "value": "Half past Ten"
}

Sample Error Payload
{
    "status": 400,
    "message": "Invalid Input."
}
