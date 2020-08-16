1. configuration server

GET : http://localhost:9001/zenca/test/latest

# RESULT

{
    "name": "zenca",
    "profiles": [
        "test"
    ],
    "label": "latest",
    "version": null,
    "state": null,
    "propertySources": [
        {
            "name": "zenca-test",
            "source": {
                "conn.host": "127.0.0.1",
                "conn.port": "33306"
            }
        }
    ]
}
