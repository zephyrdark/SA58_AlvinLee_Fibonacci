# SA58_AlvinLee_Fibonacci

## 1. Description
REST API webservice that calculates minimum number of coins needed to make up a target amount. Deployed on AWS EC2.

The inputs  are:
- Target amount – amount of money you need to make up to. Target amount must be within the range between 0 and 10,000.00
- Coin denominations – a list of coin denominations to be used to make up the target amount. Coin denomination must be one of the following values [0.01, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 50, 100, 1000]

It returns a JSON that states the target amount, coin denominations, and the minimum number of coins required to get the target amount e.g., `{"targetAmount":"1250.00","coinDenominations":[1000.0,100.0,50.0],"minimumCoins":{"1000.0":1,"100.0":2,"50":1}}`.

This repository contains the project files for the frontend (React.js) and backend (Java OpenJDK-17, Spring Boot).

## 2. Usage
1. Test the api via frontend UI at http://13.54.119.163:3000/
2. Test the api via backend at Postman
    > POST: http://13.54.119.163:8080/api/coin-request
    > Body, raw, JSON: `{"targetAmount": 1250.0,"coinDenominations": [1000.0,100.0,50.0]}`
3. Access the api via command line
    - Linux:
    > `curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"targetAmount": 1250.0,"coinDenominations": [1000.0,100.0,50.0]}' http://13.54.119.163:8080/api/coin-request`
    > ![image](https://github.com/user-attachments/assets/664a313a-8022-451e-b5e7-ab809236a2fd)

4. Cloning and building your own project.

## 3. Running the web service locally using project files (Using IDE)
1. Using any modern IDEs (Recommended: Intellij), clone the project from Version Control System, using `git@github.com:zephyrdark/SA58_AlvinLee_Fibonacci.git`.
2. Change directory to `/SA58_AlvinLee_Fibonacci/src/main/frontend`. Run the React App by running: `npm start`. It will be available at `http://localhost:3000`.
3. Run the Spring Boot application. It will be available at `http://localhost:8080/api/coin-request`, but it is recommended to use Postman as described in Usage Section.

## 4. Building and running the web service locally using project files (Without IDE)

### Git Clone
In your target directory, run `git clone git@github.com:zephyrdark/SA58_AlvinLee_Fibonacci.git`

### Frontend (React.js App)
1. Change directory to `/SA58_AlvinLee_Fibonacci/src/main/frontend`.
2. Build the React App by running: `npm run build`
3. Serve the React App by running: `serve -s build`

### Backend (Spring Boot Server)
1. Change directory to `/SA58_AlvinLee_Fibonacci`.
2. Start your application by running: `docker compose up --build`.
3. Your application will be available at http://localhost:8080.

## 5. Deploying your application to the cloud
Consult Docker's [getting started](https://docs.docker.com/go/get-started-sharing/)
docs for more detail on building and pushing.

## 6. Docker Image 
Docker image of this project is automatically build and pushed using GitHub Actions workflow, and is available at https://hub.docker.com/repository/docker/alvinlee24/fibonacci-coins/general.
