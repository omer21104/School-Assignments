#include "Pizza.h"

Pizza::Pizza(char* type, float baseprice, int num_top)
{
	this->type = NULL;
	setType(type);
	this->baseprice = baseprice;
	this->num_top = num_top;
	setToppings(); // init toppings array
}

Pizza::Pizza(const Pizza& other)
{
	this->type = NULL;
	*this = other; // use overloaded = operator
}

Pizza& Pizza::operator=(const Pizza& other)
{
	if (this != &other) // prevent self assignment
	{
		this->setType(other.type);
		this->baseprice = other.baseprice;
		this->num_top = other.num_top;
		this->copyToppings(other.toppings, other.num_top);
	}
	return *this;
}

void Pizza::copyToppings(Topping* toppings, int num_top)
{
	// method to copy array of toppings element by element
	delete[] this->toppings; // delete previous value
	this->toppings = new Topping[num_top];
	for (int i = 0; i < num_top; i++)
	{
		this->toppings[i] = toppings[i];
	}
}

Pizza::~Pizza()
{
	delete[] type;
	delete[] toppings;
}

void Pizza::setType(char* type)
{
	delete[] this->type;
	this->type = new char[strlen(type) + 1];
	assert(this->type); // assert mem allocation successful
	strcpy_s(this->type, strlen(type) + 1, type);
}

void Pizza::setToppings()
{
	// init a new array of Topping of length num_top
	// each topping is created with default constructor
	toppings = NULL;
	toppings = new Topping[num_top]; // array of default toppings
	assert(toppings); // verify mem allocation
}

void Pizza::operator+(const Topping& topping)
{
	// insert topping into array at free space
	// default topping means free space
	int index = -1;
	// find if theres a free space for topping
	for (int i = 0; i < num_top; i++)
	{
		if (toppings[i].getPrice() == 0)
		{
			index = i;
			break;
		}
	}
	if (index != -1) // found a free space
		toppings[index] = topping;
	else
		std::cout << "No free space for topping" << std::endl;
}

bool Pizza::operator==(const Pizza& other)
{
	// go through toppings array, return false if any mismatch
	for (int i = 0; i < num_top; i++)
	{
		if (!(this->toppings[i] == other.toppings[i]))
			return false;
	}
	return true;
}

float Pizza::calcPrice() const
{
	float finalPrice = 0;
	finalPrice += baseprice;
	for (int i = 0; i < num_top; i++)
	{
		finalPrice += toppings[i].getPrice();
	}
	return finalPrice;
}

std::ostream& operator<<(std::ostream& cout, const Pizza& pizza)
{
	std::cout << "Type: " << pizza.type << ", " << std::endl;
	std::cout << "Toppings: " << std::endl;
	for (int i = 0; i < pizza.num_top; i++)
	{
		std::cout << pizza.toppings[i];
	}
	std::cout << "Price: " << pizza.calcPrice() << std::endl;
	return cout;
}
