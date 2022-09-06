# Basic_WMS
Basic WMS app for tracking single SKU

Whole scope of this project is creating a simple app to handle small db of warehouse inventory, considering one stock keeping unit:

1) PalletSpace serves as a location to store an SKU which corresponds to physical space on the warehouse.
2) Pallet is the smallest, undividable unit for the SKU we are tracking.
3) Document serves as a bucket for any outgoing transaction to be able to backtrack and analyze warehouse moves in order to keep data consistent with reality.

Rudimentary CRUD API allows for db setup and data modification, production environment should be limited to Creating Pallets and Creating documents.
Only way to get rid of a pallet is to execute an outbound document, effectively flagging it as "isInWarehouse = false".

Additionally external API for QR Code Generation has been implemented in order to easily print tags for both palletSpaces and pallets for user's convenience.
Basic authentication handled via Spring Security

~hryniuklukas
