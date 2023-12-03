

#Use an official Node.js parent image
FROM node:14                 

#Set the working directory in the container
WORKDIR /app                 

#Copy package.json to the working directory
COPY package*.json ./        

#Install app dependencies
RUN npm install              

# Copy the current directory contents into the container at /app
COPY . .                     

# Expose port 3000
EXPOSE 3000                  

# Run the application
CMD ["npm", "start"]         