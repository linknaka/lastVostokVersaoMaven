package com.example;

public class cartas {

    //Nome, script de efeito, numero
    String[][] cartas=new String[210][3];
    int[] arrayFood=new int[100];
    int[] arrayWood=new int[100];
    int[] arrayTechs=new int[100];
    int[] arrayWeaps=new int[100];
    int indexCards=0;
    int indexFood=0;
    int indexWood=0;
    int indexTechs=0;
    int indexWeaps=0;
    public cartas(){
        //Adiciona index no array especifico primeiro, depois cria a descrição da carta
        putCard(1, indexCards, 3);
        createCard("Pedaço de carne",1,5);
        putCard(1, indexCards, 2);
        createCard("Carne de urso",1,35);
        putCard(2, indexCards, 7);
        createCard("Lenha",2,5);
        putCard(2, indexCards, 3);
        createCard("Arvore mitica",2,20);
        putCard(3, indexCards, 1);
        createCard("Lareira",3,1);
    }

    public void createCard(String nome, int efeito, int numeroEfeito){
        cartas[indexCards][0]=nome;
        cartas[indexCards][1]=efeito+"";
        cartas[indexCards][2]=numeroEfeito+"";
        indexCards++;
    }

    public void putCard(int arrayNum,int indexCards,int quantity){
        if(arrayNum==1){ //Se arrayNum=1 então é food
            for(int i=0;i<=quantity;i++){  //Repete quantity vezes
                arrayFood[indexFood]= indexCards;
                indexFood++;
            }
        }

        if(arrayNum==2){ //Se arrayNum=2 então é Wood
            for(int i=0;i<=quantity;i++){  //Repete quantity vezes
                arrayWood[indexWood]= indexCards;
                indexWood++;
            }
        }
        
        if(arrayNum==3){ //Se arrayNum=3 então é Tech
            for(int i=0;i<=quantity;i++){  //Repete quantity vezes
                arrayTechs[indexTechs]= indexCards;
                indexTechs++;
            }
        }
        if(arrayNum==4){ //Se arrayNum=4 então é Weapon
            for(int i=0;i<=quantity;i++){  //Repete quantity vezes
                arrayWeaps[indexWeaps]= indexCards;
                indexWeaps++;
            }
        }

    }

    public int randomPullNum(int arrayNum){
        int result=-1;
        if(arrayNum==1){ //Se arrayNum=1 então é food
            int ran= (int)(Math.random() * indexFood);  //Random de 0 a indexfood-1
                result=arrayFood[ran];  //Pega o id da carta no monte de comida
        }
        if(arrayNum==2){ //Se arrayNum=2 então é wood
            int ran= (int)(Math.random() * indexWood);  //Random de 0 a indexWood-1
                result=arrayWood[ran];  //Pega o id da carta no monte de madeira
        }
        if(arrayNum==3){ //Se arrayNum=2 então é Tech
            int ran= (int)(Math.random() * indexTechs);  //Random de 0 a indexTechs-1
                result=arrayTechs[ran];  //Pega o id da carta no monte de techs
        }
        if(arrayNum==4){ //Se arrayNum=2 então é Weapons
            int ran= (int)(Math.random() * indexWeaps);  //Random de 0 a indexWeaps-1
                result=arrayWeaps[ran];  //Pega o id da carta no monte de armas
        }
        return result;
    }

    public String printCard(int idcard){
        return cartas[idcard][0]+ " x " +cartas[idcard][2]; //Pega o nome da carta resultante e a quantidade                
    }


}

