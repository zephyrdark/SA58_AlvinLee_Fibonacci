**[NOTE]**: As of 1 Aug 2024, I have stopped the AWS EC2 instance. This repository will remain available.

---

# Coin Change Calculator

## 1. Description
REST API webservice that calculates minimum number of coins needed to make up a target amount. Deployed on AWS EC2.

The inputs  are:
- Target amount – amount of money you need to make up to. Target amount must be within the range between 0 and 10,000.00.
- Coin denominations – a list of coin denominations to be used to make up the target amount. Coin denomination must be one of the following values `[0.01, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 50, 100, 1000]`.

It returns a JSON that states the target amount, coin denominations, and the minimum number of coins required to get the target amount e.g., `{"targetAmount":"1250.00","coinDenominations":[1000.0,100.0,50.0],"minimumCoins":{"1000.0":1,"100.0":2,"50":1}}`.

This repository contains the project files for the frontend (React.js) and backend (Java 17, Spring Boot).

### *_Disclaimer_
The project is not fully fleshed out, and is still lacking the following:
1. Backend Validations
2. Comprehensive Backend Tests
3. Frontend (Mobile) Validations
4. Frontend (Web/Mobile) Tests

## 2. Building and running the web service locally using project files and Docker Desktop (No IDE Required)

### Git Clone
1. In your target directory, run
    ```
    git clone git@github.com:zephyrdark/SA58_AlvinLee_Fibonacci.git
    ```

### Full Web-App (Frontend React.js + Backend Spring)
2. Ensure that your `Docker Desktop` is running.
1. Change directory to `/SA58_AlvinLee_Fibonacci/`.
2. Build the Wep-App by running:
   ```
   docker compose up --build
   ```
4. The frontend will be available at `http://localhost:3000`, and it is hardcoded to access its accompanying backend at `http://localhost:8080`.
5. If you want, you can also use Postman to test the APIs as described in [Various Usages](https://github.com/zephyrdark/SA58_AlvinLee_Fibonacci/blob/main/README.md#2-various-usages).


## 3. Various Usages
- Test the api via frontend UI at `PROTOCOL://IP-ADDRESS:3000/`
- Test the api via backend at Postman
    > Example POST Request: `PROTOCOL://IP-ADDRESS:8080/api/coin-request`, HTTP Body, raw, JSON:
    > ```
    > {
    >     "targetAmount": 1250.0,
    >     "coinDenominations": [1000.0,100.0,50.0]
    > }
    > ```
    > Expected POST Response on Status `200 OK`:
    > ```
    > {
    >     "targetAmount": "1250.0",
    >     "coinDenominations": [
    >         "1000.0",
    >         "100.0",
    >         "50.0"
    >     ],
    >     "minimumCoins": {
    >         "1000.0": 1,
    >         "100.0": 2,
    >         "50.0": 1
    >     }
    > }
    > ```
    
- Access the api via command line
    - Linux:
    > ```
    > curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"targetAmount": 1250.0,"coinDenominations": [1000.0,100.0,50.0]}' PROTOCOL://IP-ADDRESS:8080/api/coin-request
    > ```
    > ![image](https://github.com/user-attachments/assets/664a313a-8022-451e-b5e7-ab809236a2fd)

- Cloning and building your own project.

## 4. Deploying your application to the cloud
Consult Docker's [getting started](https://docs.docker.com/go/get-started-sharing/)
docs for more detail on building and pushing.

You will need to make adjustments to the hardcoded IP-ADDRESS used for axios in `SA58_AlvinLee_Fibonacci/frontend-react/src/CoinRequest.js`'s `submit()`.

## 5. Docker Image 
Docker image of this project is automatically build and pushed using GitHub Actions workflow, and is available at https://hub.docker.com/repository/docker/alvinlee24/fibonacci-coins/general.
