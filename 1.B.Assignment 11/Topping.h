// Submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
#pragma once
#include <iostream>
#include <cassert>
class Topping
{
private:
	char* name;
	float price; // full tray price for topping
	char coverage; // {'r' - right, 'l' - left, 'f' - full}
public:
	// constructors
	Topping();
	Topping(char* name, char coverage, float price);
	Topping(const Topping& other); // copy constructor
	~Topping();

	// get, set methods
	void setName(char* name);
	float getPrice() const { return price; }
	char* getName() const { return name; }

	// operators overload
	Topping& operator=(const Topping& other);
	friend std::ostream& operator<<(std::ostream& cout, const Topping& topping);
	bool operator>(const Topping& other);
	bool operator<(const Topping& other);
	bool operator==(const Topping& other);
};

