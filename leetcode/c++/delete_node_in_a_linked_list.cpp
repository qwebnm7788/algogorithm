#include <iostream>
using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
	void deleteNode(ListNode *node) {
		node->val = node->next->val;
		node->next = node->next->next;
	}
};

int main() {
	ios_base::sync_with_stdio(false);


	return 0;
}
