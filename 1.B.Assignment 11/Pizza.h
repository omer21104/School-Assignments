// Submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
#pragma once
#include "Topping.h"
class Pizza
{
private:
	char* type; // dough type
	float baseprice;
	Topping* toppings; // array of toppings of pizza
	int num_top;
public:
	// Constructors
	Pizza(char* type, float baseprice, int num_top);
	Pizza(const Pizza& other);
	~Pizza();

	// get, set methods
	void setType(char* type);
	void setToppings();
	void copyToppings(Topping* toppings, int num_top);

	// operators overload
	Pizza& operator=(const Pizza& other);
	friend std::ostream& operator<<(std::ostream& cout, const Pizza& pizza);
	void operator+(const Topping& topping);
	bool operator==(const Pizza& other);

	// other methods
	float calcPrice() const;
};

