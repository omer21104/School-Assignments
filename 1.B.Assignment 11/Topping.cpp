// Submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
#include "Topping.h"

Topping::Topping()
{
	name = NULL;
	price = 0;
	coverage = 'f';
}

Topping::Topping(char* name,  char coverage, float price = 10)
{
	this->name = NULL;
	setName(name);
	this->coverage = coverage;
	this->price = price;
}

Topping::Topping(const Topping& other)
{
	this->name = NULL;
	*this = other; // use overloaded = operator
}

Topping& Topping::operator=(const Topping& other)
{
	if (this != &other) // prevent self assignment
	{
		this->setName(other.name);
		this->coverage = other.coverage;
		this->price = other.price;
	}
	return *this;
}

Topping::~Topping()
{
	delete[] name;
}

void Topping::setName(char* name)
{
	delete[] this->name;
	this->name = new char[strlen(name) + 1];
	assert(this->name); // assert mem allocation successful
	strcpy_s(this->name, strlen(name) + 1, name);
}


bool Topping::operator>(const Topping& other)
{
	return this->price > other.price;
}

bool Topping::operator<(const Topping& other)
{
	return this->price < other.price;
}

bool Topping::operator==(const Topping& other)
{
	return this->coverage == other.coverage;
}

std::ostream& operator<<(std::ostream& cout, const Topping& topping)
{
	std::cout << "Topping: " << topping.name << ", " << "Price: " << topping.price << ", " << "Coverage: " << topping.coverage << std::endl;
	return cout;
}
