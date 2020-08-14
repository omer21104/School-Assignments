// Submitted by Omer Zano - 315740118 && Gal Aloush 206115156
#pragma once
#include "Animal.h"
class Cat:public Animal
{
protected:
	const int tail_length;
	int num_of_souls;
	char* breed;
public:
	Cat(int age, const char* sound, int tail_length, int num_of_souls, const char* breed);
	Cat(const Cat& other);
	virtual ~Cat();
	Cat& operator=(const Cat& other);
	void make_fur_ball();
	virtual int calcFood() = 0;
	void set_breed(const char* breed);
	
};

