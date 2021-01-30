# Docker commands

## run
- it is used to run a container from an image on the docker host if already exist
- Or if the image is not present on the host it will go out to docker hub and pull the image down => happen one time => for the subsequent executions the same image will be reused 
- you can append a command to the running command such as `docker run ubuntu sleep 5`

> docker run ubuntu 
>
> docker run --rm ubuntu    // it will remove the container once the container stoped 
>

## list all runing container 
- it lists all the running containers with some basic information about them 
> docker ps

## list all container 
- used to inspect all the containers running and previously executed and stoped containers 
> docker ps -a 

## stop
- to stop or kill a running container 
> docker stop container_name or container_id

## restart
- to restart a running container 
> docker restart container_name or container_id

## remove a container 
- it is possible to provide more than one container_name or id (first 4 digits is enough) to the rm command 
> docker rm container_name or container_id 


## list of images 
- list all the images available on the docker host
> docker images 

## remove an image 
- Stop and Remove all dependent containers to the image you want to remove
> docker rmi image_name 

## download an image 
> docker pull image_name 

- containers are not meant to host an operating system => container are meant to run a specific task or process => once the task is complete the container exits
- a container only lives as long as the process inside it is alive => once the process ends or crashes the container exit 

## execute a command 
- other than appending a command to the run command 
- the exec command is used to execute a command on a running container 
> docker exec container_name cat /etc/*release*
>
> docker exec -it container_name bash

## run attach and detach mode 
- the attached mode is the default mode when running a container => it means that when you run a command you will be attached to the console or the standard out of the docker container => you won't be able to do anything else on this console beside viewing the output until this container stops 
- the container in attached mode won't respond to your input
- the detached mode runs the docker container in the backckground and it will be back to your prompt imediately
> docker run -d ubuntu 

> docker attach container_id // to go back the attach mode


## i interactive mode + t terminal
> docker run -it centos bash
>
> sudo docker run --name container_name image_name
>
- every docker container has an internal ip of **172.17.0.2** => only accessible within the docker host 

## p 
- to map the container port to another accessible port 
> docker run -p 80:5000 container_name
- like so all the trafic on the port 80 of the docker host will be lead to the container running on port 5000
- you cannot map on the same docker host post more than once 

- a docker container has its own file system 

> docker run mysql
>
> docker run -v /opt/datadir:/var/lib/mysql mysql  // here we are maping the data storage of mysql from the file system inside the docker to a directory we created inside the docker host outside the container 

## inspect container 
- you can see all the information related to the container or image even the envirnment variables 
> docker inspect container_name or container_id 

## container logs
> docker logs container_name or container_id

## environment variable
> sudo docker run -e VARIABLE_NAME=value image_name

## command
> CMD command param1
>
> CMD ["command", "param1"]  /json format

## entrypoint 
- it is like the command
- the param1 will be given during running the container
> ENTRYPOINT ["command"]
>
> sudo docker run ubuntu-sleeper 10  //the entrypoint of this container is ["sleep"]

- in order to have a default value in case the running command didn't specify a parameter use the entrypoint and the command as below
> ENTRYPOINT["sleep"]
>
> CMD["5"]
>
- in case of the parameter isn't supplied the slep will be executed for 5 seconds 

- entrypoint could be overwited by specifying it in the command 
> sudo docker run --entrypoint sleep2.0 ubuntu-sleeper

## docker compose
- it is a configuration file in yml format to run a complex application running multiple services 
- it contains the different services and their options specific
- applicable on containers running on a single docker host
> docker-compose up 
>
> docker-compose down

## links
- link is used to link to container together 
> docker run --link redis:redis  // the first redis is the name of the container, the second is the name of the host that we are looking for 
>
- the use of links is deprecated


## access the docker container from within your local machine 
- **192.168.1.14:port_number**


## copy a file from and to docker container 
> docker cp container_id:file_path_in_container file_path_and_file_on_local_machine
>
> docker cp file_path_and_file_on_local_machine container_id:file_path_in_container

