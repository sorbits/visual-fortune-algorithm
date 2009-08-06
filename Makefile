build:
	javac -source 1.3 -d html src/*.java

deploy: build
	rsync -avz --rsh=ssh --exclude .DS_Store html/ diku:Fortune

clean:
	rm -f html/*.class
