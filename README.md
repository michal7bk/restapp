# restapp - spring boot
Movie :
    Long id;
    Sring tittle;
    String director;
    int yearOfProduction;
    
    Get:
    /movies/{id} ->get film by Id
    /movies   -> get list of film
    
    Post:
    
    /movies   -> add film 
    
    Sample request:
    
    curl -i -H "Content-Type: application/json" -X POST -d'{
    "tittle": "Potop",
    "director": "Hoffman",
    "yearOfProduction" : "1974"
    }' localhost:8080/movies
    
    Sample response: 
    
    {
    "id":1,
    "tittle":"Potop",
    "director":"Hoffman",
    "yearOfProduction":1974
    }   
    
