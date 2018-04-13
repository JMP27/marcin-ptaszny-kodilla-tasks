#!/usr/bin/env bash

if "./runcrud.sh" then
    open http://192.168.1.25:8080/tasks/v1/task/getTasks
    echo "Work is finished :)"
else
    echo "There were errors in showtasks"
fi