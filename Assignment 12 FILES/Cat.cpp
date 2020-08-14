// Submitted by Omer Zano - 315740118 && Gal Aloush 206115156
#include "Cat.h"
#include "Animal.h"
#define FUR_LINE "fur"
Cat::Cat(int age, const char* sound, int tail_length, int num_of_souls, const char* breed): Animal(age,sound) , tail_length(tail_length), breed(NULL)
{
	this->num_of_souls = num_of_souls;
	set_breed(breed);
}

Cat::Cat(const Cat& other): Animal(other.age, other.sound), tail_length(other.tail_length)
{
	this->breed = NULL;
	// copy num_of_souls and breed
	this->num_of_souls = other.num_of_souls;
	set_breed(other.breed);
}

Cat::~Cat()
{
	delete[] breed;
}

Cat& Cat::operator=(const Cat& other)
{
	if (this != &other)
	{
		Animal::operator=(other); // assign Animal part of other
		this->num_of_souls = other.num_of_souls;
		// tail length is constant and cannot be assigned from other
		// handle in copy constructor
		set_breed(other.breed);
	}
	return *this;
}

void Cat::make_fur_ball()
{
	for (int i = 0; i < tail_length; i++)
		cout << FUR_LINE << " "; // print "fur" x tail_length
	cout << endl;
}


void Cat::set_breed(const char* breed)
{
	delete[] this->breed;
	this->breed = new char[strlen(breed) + 1];
	assert(this->breed);
	strcpy_s(this->breed, strlen(breed) + 1, breed);

}
