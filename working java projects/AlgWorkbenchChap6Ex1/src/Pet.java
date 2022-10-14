public class Pet
{
    private String name;            // Holds the name of the pet
    private String animal;          // Hold the type of animal that a pet is
    private int age;                // Holds the pet's age

    /**
     * setName method
     * @param n The pet's name
     */
    public void setName(String n)
    {
        name = n;
    }

    /**
     * setAnimal method
     * @param a The animal's type
     */
    public void setAnimal(String a)
    {
        animal = a;
    }

    /**
     * setAge method
     * @param a The pet's age
     */
    public void setAge(int a)
    {
        age = a;
    }

    /**
     * getName method
     * @return The pet's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * getAnimal method
     * @return The animal's type
     */
    public String getAnimal()
    {
        return animal;
    }

    /**
     * getAge method
     * @return The pet's age
     */
    public int getAge()
    {
        return age;
    }
}
