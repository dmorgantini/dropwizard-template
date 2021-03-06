#!/bin/sh
# usage ./convert.sh [newName]

newName=$1

cd ..

cp -R dropwizard-template dropwizard-${newName}

cd dropwizard-${newName}

rm -fr ./.git/

mv ./src/main/java/ca/morgantini/dropwizard/template/ ./src/main/java/ca/morgantini/dropwizard/${newName}

cd ./src/main/java/ca/morgantini/dropwizard/${newName}

for file in *.java **/*.java
do
    sed "s/\.template/\.${newName}/g" ${file} > ${file}
    sed "s/TemplateApplication/${newName}Application/g" ${file} > ${file}
done


