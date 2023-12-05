class TestAnnonymousInner1{  
 public static void main(String args[])
 {  
  //annonymous inner type
  Eatable E = new Eatable() 
  {
    @Override
    public void eat() 
    {
     // throw new UnsupportedOperationException("Unimplemented method 'eat'");
      System.out.println("nice friuts");
    }
  };
  E.eat();
  }
}  
