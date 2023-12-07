package objcom;
class book

{
    int id;
    String name ;
    book(int id ,  String name)
    {
     this.name = name;
     this.id = id;
    }
    public boolean equals(Object b2)
   {
      if(this == b2)
            return true;
        if(b2 == null || b2.getClass()!= this.getClass())
            return false;
        book book = (book) b2;
        return (book.name == this.name && book.id == this.id);
   }
   public int hashCode()
   {
    return this.id;
   }
}
