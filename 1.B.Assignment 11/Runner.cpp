// Submitted by Omer Zano - 315740118 && Gal Aloush - 206115156
#include "Pizza.h"
#include "Topping.h"

#define LEN 100
Topping createTopping();
Pizza createPizza();
int main()
{
	std::cout << "Welcome to the Pizza shop" << std::endl;
	// create first pizza
	Pizza p1 = createPizza();
	// create second pizza
	Pizza p2 = createPizza();
	std::cout << "First pizza: " << std::endl;
	std::cout << p1 << std::endl;
	std::cout << "second pizza: " << std::endl;
	std::cout << p2 << std::endl;
	std::cout << "p1 == p2: " << ((p1 == p2) ? "true" : "false") << std::endl;
	char top1[] = "pepper";
	char top2[] = "onion";
	Topping t1(top1, 'f', 100);
	Topping t2(top2, 'f', 50);
	Topping t3(top1, 'r', 33.3);
	std::cout << "t1 > t2: " << ((t1 > t2) ? "true" : "false") << std::endl;
	std::cout << "t2 > t3: " << ((t3 > t2) ? "true" : "false") << std::endl;


	return 0;
}

Topping createTopping()
{
	char name[LEN];
	// set random price for topping in range [1,10]
	float price = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / 9)) + 1; 
	char coverage;
	std::cout << "Enter topping name: ";
	std::cin.get(name, LEN);
	std::cout << "Enter coverage for topping (l)eft (r)ight (f)ull: ";
	std::cin >> coverage;
	std::cin.ignore();
	Topping tmp(name, coverage, price);
	return tmp;
}

Pizza createPizza()
{
	int num_top;
	char type[LEN];
	// random base price in range [15,50]
	float baseprice = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / 35)) + 15; 
	std::cout << "Enter dough type: ";
	std::cin.get(type, LEN);
	std::cout << "enter number of toppings: ";
	std::cin >> num_top;
	std::cin.ignore();

	Pizza tmp(type, baseprice, num_top);
	for (int i = 0; i < num_top; i++)
	{
		Topping t = createTopping(); // add topping to pizza
		tmp + t;
	}
	return tmp;
}