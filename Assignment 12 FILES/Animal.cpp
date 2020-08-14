// Submitted by Omer Zano - 315740118 && Gal Aloush 206115156
#include "Animal.h"

Animal::Animal(int age, const char* sound):age(age), sound(NULL)
{
	set_sound(sound);
}

Animal::Animal(const Animal& other)
{
	this->sound = NULL;
	*this = other;
}

Animal::~Animal()
{
	delete[] sound;
}


Animal& Animal::operator=(const Animal& other)
{
	if (this != &other)
	{
		this->age = other.age;
		set_sound(other.sound);
	}
	return *this;
}

void Animal::set_sound(const char* sound)
{
	delete[] this->sound;
	this->sound = new char[strlen(sound) + 1];
	assert(this->sound);
	strcpy_s(this->sound, strlen(sound) + 1, sound);
}

